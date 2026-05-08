/**
 * VALIDATION.JS
 * Comprehensive form validation covering all syllabus requirements:
 * - First Name: alphabets only, min 6 chars
 * - Password: min 6 chars
 * - Email: standard pattern name@domain.com
 * - Mobile Number: 10 digits only
 * - Last Name & Address: non-empty
 */

// ============================================================
// 1. FIRST NAME VALIDATION
// ============================================================
function validateFirstName(firstName) {
    const errorElement = document.getElementById('firstNameError');
    
    // Clear previous error
    if (errorElement) errorElement.textContent = '';

    // Check if empty
    if (!firstName || firstName.trim() === '') {
        showError('firstNameError', 'First name is required');
        return false;
    }

    // Check if contains only alphabets (and spaces)
    const alphabetOnly = /^[a-zA-Z\s]+$/;
    if (!alphabetOnly.test(firstName)) {
        showError('firstNameError', 'First name should contain only alphabets');
        return false;
    }

    // Check minimum length of 6 characters
    if (firstName.length < 6) {
        showError('firstNameError', 'First name must be at least 6 characters');
        return false;
    }

    return true;
}

// Real-time validation for first name
document.addEventListener('DOMContentLoaded', function() {
    const firstNameInput = document.getElementById('firstName');
    if (firstNameInput) {
        firstNameInput.addEventListener('blur', function() {
            validateFirstName(this.value);
        });

        firstNameInput.addEventListener('input', function() {
            // Real-time feedback
            const errorElement = document.getElementById('firstNameError');
            if (errorElement && this.value) {
                if (!/^[a-zA-Z\s]*$/.test(this.value)) {
                    errorElement.textContent = 'Only alphabets allowed';
                } else if (this.value.length < 6) {
                    errorElement.textContent = `${6 - this.value.length} more characters needed`;
                } else {
                    errorElement.textContent = '';
                }
            }
        });
    }
});

// ============================================================
// 2. LAST NAME VALIDATION
// ============================================================
function validateLastName(lastName) {
    const errorElement = document.getElementById('lastNameError');
    
    if (errorElement) errorElement.textContent = '';

    // Check if empty
    if (!lastName || lastName.trim() === '') {
        showError('lastNameError', 'Last name is required');
        return false;
    }

    // Last name should also contain only alphabets
    const alphabetOnly = /^[a-zA-Z\s]+$/;
    if (!alphabetOnly.test(lastName)) {
        showError('lastNameError', 'Last name should contain only alphabets');
        return false;
    }

    return true;
}

// Real-time validation for last name
document.addEventListener('DOMContentLoaded', function() {
    const lastNameInput = document.getElementById('lastName');
    if (lastNameInput) {
        lastNameInput.addEventListener('blur', function() {
            validateLastName(this.value);
        });
    }
});

// ============================================================
// 3. EMAIL VALIDATION
// ============================================================
function validateEmail(email) {
    const errorElement = document.getElementById('emailError');
    
    if (errorElement) errorElement.textContent = '';

    // Check if empty
    if (!email || email.trim() === '') {
        showError('emailError', 'Email is required');
        return false;
    }

    // Standard email pattern: name@domain.com
    // Pattern breakdown:
    // ^[^\s@]+ : One or more characters that are not space or @
    // @ : Literal @ symbol
    // [^\s@]+ : One or more characters that are not space or @
    // \. : Literal dot
    // [^\s@]+ : One or more characters that are not space or @ (TLD)
    // $ : End of string
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    
    if (!emailPattern.test(email)) {
        showError('emailError', 'Invalid email format. Use: name@domain.com');
        return false;
    }

    // Additional check: should not contain multiple @ symbols
    if ((email.match(/@/g) || []).length !== 1) {
        showError('emailError', 'Email should contain only one @ symbol');
        return false;
    }

    return true;
}

// Real-time validation for email
document.addEventListener('DOMContentLoaded', function() {
    const emailInput = document.getElementById('regEmail');
    if (emailInput) {
        emailInput.addEventListener('blur', function() {
            validateEmail(this.value);
        });

        emailInput.addEventListener('input', function() {
            const errorElement = document.getElementById('emailError');
            if (errorElement && this.value) {
                const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
                if (!emailPattern.test(this.value)) {
                    errorElement.textContent = 'Invalid format';
                } else {
                    errorElement.textContent = '';
                }
            }
        });
    }
});

// ============================================================
// 4. MOBILE NUMBER VALIDATION
// ============================================================
function validatePhone(phone) {
    const errorElement = document.getElementById('phoneError');
    
    if (errorElement) errorElement.textContent = '';

    // Remove any spaces or dashes
    const cleanedPhone = phone.replace(/[\s\-()]/g, '');

    // Check if empty
    if (!cleanedPhone || cleanedPhone === '') {
        showError('phoneError', 'Mobile number is required');
        return false;
    }

    // Check if contains only digits
    if (!/^\d+$/.test(cleanedPhone)) {
        showError('phoneError', 'Mobile number should contain only digits');
        return false;
    }

    // Check if exactly 10 digits
    if (cleanedPhone.length !== 10) {
        showError('phoneError', 'Mobile number must be exactly 10 digits');
        return false;
    }

    // Optional: Check if starts with valid Indian mobile digit (6-9)
    if (!/^[6-9]/.test(cleanedPhone)) {
        showError('phoneError', 'Indian mobile numbers should start with 6-9');
        return false;
    }

    return true;
}

// Real-time validation for phone
document.addEventListener('DOMContentLoaded', function() {
    const phoneInput = document.getElementById('regPhone');
    if (phoneInput) {
        phoneInput.addEventListener('blur', function() {
            validatePhone(this.value);
        });

        phoneInput.addEventListener('input', function() {
            const errorElement = document.getElementById('phoneError');
            if (errorElement) {
                const cleanedPhone = this.value.replace(/[\s\-()]/g, '');
                
                if (this.value && cleanedPhone.length < 10) {
                    errorElement.textContent = `${10 - cleanedPhone.length} digits remaining`;
                } else if (cleanedPhone.length > 10) {
                    errorElement.textContent = 'Too many digits';
                } else if (cleanedPhone.length === 10) {
                    errorElement.textContent = '';
                }
            }
        });
    }
});

// ============================================================
// 5. PASSWORD VALIDATION
// ============================================================
function validatePassword(password) {
    const errorElement = document.getElementById('passwordError');
    
    if (errorElement) errorElement.textContent = '';

    // Check if empty
    if (!password || password === '') {
        showError('passwordError', 'Password is required');
        return false;
    }

    // Check minimum length of 6 characters
    if (password.length < 6) {
        showError('passwordError', 'Password must be at least 6 characters');
        return false;
    }

    return true;
}

// Real-time validation for password
document.addEventListener('DOMContentLoaded', function() {
    const passwordInput = document.getElementById('regPassword');
    if (passwordInput) {
        passwordInput.addEventListener('blur', function() {
            validatePassword(this.value);
        });

        passwordInput.addEventListener('input', function() {
            const errorElement = document.getElementById('passwordError');
            if (errorElement && this.value) {
                if (this.value.length < 6) {
                    errorElement.textContent = `${6 - this.value.length} more characters needed`;
                } else {
                    errorElement.textContent = '';
                }
            }
        });
    }
});

// ============================================================
// 6. ADDRESS VALIDATION
// ============================================================
function validateAddress(address) {
    const errorElement = document.getElementById('addressError');
    
    if (errorElement) errorElement.textContent = '';

    // Check if empty or only whitespace
    if (!address || address.trim() === '') {
        showError('addressError', 'Address is required');
        return false;
    }

    // Check minimum length (at least 10 characters)
    if (address.trim().length < 10) {
        showError('addressError', 'Address must be at least 10 characters');
        return false;
    }

    return true;
}

// Real-time validation for address
document.addEventListener('DOMContentLoaded', function() {
    const addressInput = document.getElementById('regAddress');
    if (addressInput) {
        addressInput.addEventListener('blur', function() {
            validateAddress(this.value);
        });

        addressInput.addEventListener('input', function() {
            const errorElement = document.getElementById('addressError');
            if (errorElement && this.value) {
                const length = this.value.trim().length;
                if (length < 10) {
                    errorElement.textContent = `${10 - length} more characters needed`;
                } else {
                    errorElement.textContent = '';
                }
            }
        });
    }
});

// ============================================================
// HELPER FUNCTIONS
// ============================================================

function showError(elementId, message) {
    const element = document.getElementById(elementId);
    if (element) {
        element.textContent = message;
        element.style.display = 'block';
    }
}

function clearError(elementId) {
    const element = document.getElementById(elementId);
    if (element) {
        element.textContent = '';
        element.style.display = 'none';
    }
}

// Validate entire form
function validateRegistrationForm() {
    const firstName = document.getElementById('firstName').value;
    const lastName = document.getElementById('lastName').value;
    const email = document.getElementById('regEmail').value;
    const phone = document.getElementById('regPhone').value;
    const address = document.getElementById('regAddress').value;
    const password = document.getElementById('regPassword').value;

    return validateFirstName(firstName) &&
           validateLastName(lastName) &&
           validateEmail(email) &&
           validatePhone(phone) &&
           validateAddress(address) &&
           validatePassword(password);
}

// ============================================================
// DEMO VALIDATION RUNNER
// ============================================================

function runValidationTests() {
    console.log('=== VALIDATION TESTS ===\n');

    // Test cases for First Name
    console.log('First Name Tests:');
    console.log('Valid "Alexander" (8 chars, alphabets):', validateFirstName('Alexander'));
    console.log('Invalid "Joh" (3 chars):', validateFirstName('Joh'));
    console.log('Invalid "John123" (contains numbers):', validateFirstName('John123'));

    // Test cases for Email
    console.log('\nEmail Tests:');
    console.log('Valid "user@domain.com":', validateEmail('user@domain.com'));
    console.log('Invalid "user@domain":', validateEmail('user@domain'));
    console.log('Invalid "user domain.com":', validateEmail('user domain.com'));

    // Test cases for Phone
    console.log('\nPhone Tests:');
    console.log('Valid "9876543210":', validatePhone('9876543210'));
    console.log('Invalid "12345" (5 digits):', validatePhone('12345'));
    console.log('Invalid "12345678901" (11 digits):', validatePhone('12345678901'));
    console.log('Invalid "1234567890" (starts with 1):', validatePhone('1234567890'));

    // Test cases for Password
    console.log('\nPassword Tests:');
    console.log('Valid "password123" (6+ chars):', validatePassword('password123'));
    console.log('Invalid "pass" (4 chars):', validatePassword('pass'));

    // Test cases for Address
    console.log('\nAddress Tests:');
    console.log('Valid "123 Main Street, City":', validateAddress('123 Main Street, City'));
    console.log('Invalid "123 Main" (too short):', validateAddress('123 Main'));
}

// Uncomment to run tests in browser console
// runValidationTests();
