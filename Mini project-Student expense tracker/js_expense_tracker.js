/**
 * EXPENSE TRACKER.JS
 * Main application logic for expense tracking
 */

// ============================================================
// EXPENSE DATA MANAGEMENT
// ============================================================

class ExpenseTracker {
    constructor() {
        this.expenses = this.loadExpenses();
        this.init();
    }

    init() {
        this.setupEventListeners();
        this.render();
    }

    setupEventListeners() {
        const expenseForm = document.getElementById('expenseForm');
        if (expenseForm) {
            expenseForm.addEventListener('submit', (e) => this.addExpense(e));
        }
    }

    // Add new expense
    addExpense(event) {
        event.preventDefault();

        const amount = parseFloat(document.getElementById('amount').value);
        const category = document.getElementById('category').value;
        const description = document.getElementById('description').value;
        const date = document.getElementById('date').value;

        if (!amount || !category || !description || !date) {
            alert('Please fill all fields');
            return;
        }

        const expense = {
            id: Date.now(),
            amount: amount,
            category: category,
            description: description,
            date: new Date(date),
            timestamp: new Date()
        };

        this.expenses.push(expense);
        this.saveExpenses();
        this.render();

        // Reset form
        document.getElementById('expenseForm').reset();
        document.getElementById('date').valueAsDate = new Date();

        // Show success message
        this.showNotification('Expense added successfully!', 'success');
    }

    // Delete expense
    deleteExpense(id) {
        if (confirm('Are you sure you want to delete this expense?')) {
            this.expenses = this.expenses.filter(exp => exp.id !== id);
            this.saveExpenses();
            this.render();
            this.showNotification('Expense deleted!', 'success');
        }
    }

    // Get expenses by category
    getExpensesByCategory(category) {
        return this.expenses.filter(exp => exp.category === category);
    }

    // Calculate total expenses
    getTotalExpenses() {
        return this.expenses.reduce((sum, exp) => sum + exp.amount, 0);
    }

    // Calculate monthly expenses
    getMonthlyExpenses() {
        const now = new Date();
        const currentMonth = now.getMonth();
        const currentYear = now.getFullYear();

        return this.expenses
            .filter(exp => {
                const expDate = new Date(exp.date);
                return expDate.getMonth() === currentMonth && 
                       expDate.getFullYear() === currentYear;
            })
            .reduce((sum, exp) => sum + exp.amount, 0);
    }

    // Get categories count
    getCategoriesCount() {
        const categories = new Set(this.expenses.map(exp => exp.category));
        return categories.size;
    }

    // Local Storage Management
    saveExpenses() {
        localStorage.setItem('expenses', JSON.stringify(this.expenses));
    }

    loadExpenses() {
        const stored = localStorage.getItem('expenses');
        if (stored) {
            const parsed = JSON.parse(stored);
            // Convert date strings back to Date objects
            return parsed.map(exp => ({
                ...exp,
                date: new Date(exp.date),
                timestamp: new Date(exp.timestamp)
            }));
        }
        return [];
    }

    // Render UI
    render() {
        this.updateDashboard();
        this.renderExpensesList();
    }

    updateDashboard() {
        const totalExpenses = this.getTotalExpenses();
        const monthlyExpenses = this.getMonthlyExpenses();
        const categoriesCount = this.getCategoriesCount();
        const transactionCount = this.expenses.length;

        document.getElementById('totalExpenses').textContent = 
            '₹' + totalExpenses.toFixed(2);
        document.getElementById('monthlyExpenses').textContent = 
            '₹' + monthlyExpenses.toFixed(2);
        document.getElementById('categoryCount').textContent = categoriesCount;
        document.getElementById('transactionCount').textContent = transactionCount;
    }

    renderExpensesList() {
        const expensesList = document.getElementById('expensesList');
        
        if (this.expenses.length === 0) {
            expensesList.innerHTML = '<p style="text-align: center; color: #999;">No expenses yet. Add one to get started!</p>';
            return;
        }

        // Sort by date (newest first)
        const sorted = [...this.expenses].sort((a, b) => 
            new Date(b.date) - new Date(a.date)
        );

        expensesList.innerHTML = sorted.map(expense => {
            const categoryClass = expense.category.toLowerCase();
            const formattedDate = this.formatDate(new Date(expense.date));

            return `
                <div class="expense-item animate-fadeInUp">
                    <div class="expense-info">
                        <span class="expense-category ${categoryClass}">${expense.category}</span>
                        <p class="expense-description">${this.escapeHtml(expense.description)}</p>
                        <p class="expense-date">${formattedDate}</p>
                    </div>
                    <div class="expense-amount">₹${expense.amount.toFixed(2)}</div>
                    <div class="expense-actions">
                        <button class="btn btn-sm btn-danger" 
                                onclick="tracker.deleteExpense(${expense.id})">
                            Delete
                        </button>
                    </div>
                </div>
            `;
        }).join('');
    }

    // Utility methods
    formatDate(date) {
        const options = { year: 'numeric', month: 'short', day: 'numeric' };
        return date.toLocaleDateString('en-IN', options);
    }

    escapeHtml(text) {
        const div = document.createElement('div');
        div.textContent = text;
        return div.innerHTML;
    }

    showNotification(message, type) {
        // Create notification element
        const notification = document.createElement('div');
        notification.className = `alert alert-${type}`;
        notification.textContent = message;
        notification.style.position = 'fixed';
        notification.style.top = '20px';
        notification.style.right = '20px';
        notification.style.zIndex = '9999';
        notification.style.minWidth = '300px';

        document.body.appendChild(notification);

        // Remove after 3 seconds
        setTimeout(() => {
            notification.remove();
        }, 3000);
    }

    // Export expenses to CSV
    exportToCSV() {
        if (this.expenses.length === 0) {
            this.showNotification('No expenses to export', 'warning');
            return;
        }

        let csv = 'Date,Category,Description,Amount\n';
        
        this.expenses.forEach(exp => {
            const date = this.formatDate(new Date(exp.date));
            csv += `"${date}","${exp.category}","${exp.description}","${exp.amount}"\n`;
        });

        this.downloadCSV(csv, 'expenses.csv');
    }

    downloadCSV(csv, filename) {
        const blob = new Blob([csv], { type: 'text/csv' });
        const url = window.URL.createObjectURL(blob);
        const a = document.createElement('a');
        a.href = url;
        a.download = filename;
        document.body.appendChild(a);
        a.click();
        window.URL.revokeObjectURL(url);
        document.body.removeChild(a);

        this.showNotification('Expenses exported to CSV!', 'success');
    }

    // Get category statistics
    getCategoryStats() {
        const stats = {};
        
        this.expenses.forEach(exp => {
            if (!stats[exp.category]) {
                stats[exp.category] = 0;
            }
            stats[exp.category] += exp.amount;
        });

        return stats;
    }

    // Filter expenses by date range
    getExpensesByDateRange(startDate, endDate) {
        return this.expenses.filter(exp => {
            const expDate = new Date(exp.date);
            return expDate >= startDate && expDate <= endDate;
        });
    }
}

// ============================================================
// INITIALIZATION
// ============================================================

let tracker;

document.addEventListener('DOMContentLoaded', function() {
    // Initialize tracker
    tracker = new ExpenseTracker();

    // Set today's date as default
    const dateInput = document.getElementById('date');
    if (dateInput) {
        dateInput.valueAsDate = new Date();
    }

    // Add keyboard shortcuts
    document.addEventListener('keydown', function(e) {
        // Ctrl+E for export
        if (e.ctrlKey && e.key === 'e') {
            e.preventDefault();
            tracker.exportToCSV();
        }
        // Ctrl+N for new expense
        if (e.ctrlKey && e.key === 'n') {
            e.preventDefault();
            document.getElementById('amount').focus();
        }
    });
});

// ============================================================
// GLOBAL FUNCTIONS (For inline onclick handlers)
// ============================================================

function addExpense(event) {
    if (tracker) {
        tracker.addExpense(event);
    }
}

function loadExpenses() {
    if (tracker) {
        tracker.render();
    }
}

function updateDashboard() {
    if (tracker) {
        tracker.updateDashboard();
    }
}

function deleteExpense(id) {
    if (tracker) {
        tracker.deleteExpense(id);
    }
}

function exportExpenses() {
    if (tracker) {
        tracker.exportToCSV();
    }
}

// ============================================================
// CHARTS & STATISTICS (if Chart.js is included)
// ============================================================

function initializeCharts() {
    if (typeof Chart === 'undefined') {
        console.warn('Chart.js not loaded');
        return;
    }

    const stats = tracker.getCategoryStats();
    const categories = Object.keys(stats);
    const amounts = Object.values(stats);

    // Category pie chart
    const ctx = document.getElementById('categoryChart');
    if (ctx) {
        new Chart(ctx, {
            type: 'doughnut',
            data: {
                labels: categories,
                datasets: [{
                    data: amounts,
                    backgroundColor: [
                        '#fef3c7',
                        '#dbeafe',
                        '#ddd6fe',
                        '#f8d5f4',
                        '#dcfce7',
                        '#fcd34d',
                        '#fbcfe8',
                        '#f3f4f6'
                    ]
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        position: 'bottom'
                    }
                }
            }
        });
    }
}

// ============================================================
// DARK MODE TOGGLE
// ============================================================

function toggleDarkMode() {
    const html = document.documentElement;
    const isDark = html.getAttribute('data-theme') === 'dark';
    
    if (isDark) {
        html.removeAttribute('data-theme');
        localStorage.setItem('theme', 'light');
    } else {
        html.setAttribute('data-theme', 'dark');
        localStorage.setItem('theme', 'dark');
    }
}

// Load theme preference
document.addEventListener('DOMContentLoaded', function() {
    const savedTheme = localStorage.getItem('theme');
    if (savedTheme === 'dark') {
        document.documentElement.setAttribute('data-theme', 'dark');
    }
});
