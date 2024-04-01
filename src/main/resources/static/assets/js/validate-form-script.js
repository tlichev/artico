const form = document.getElementById("contactForm");
const username = document.getElementsByName("username")[0];
const password = document.getElementsByName("password")[0];

form.addEventListener('submit', e => {
    e.preventDefault();

    validateInputs();
});


const setSuccess = (element) => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector(".error");

    errorDisplay.innerText = "";
}
const setError = (element, message) => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector(".error");

    errorDisplay.innerText = message;
}

const isValidPassword = password => {
    const re = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$";
    return re.test(String(password));
}
const validateInputs = () => {
    const usernameValue = username.value.trim();
    const passwordValue = password.value.trim();

    if (usernameValue.length <= 4) {
        setError(username, "Username must be at least 4 characters");
    } else {
        setSuccess(username);
    }

    if (passwordValue.length <= 4) {
        setError(password, "Password must be at least 4 characters");
    } else if (!isValidPassword(passwordValue)) {
        setError(password, "Password must contain uppercase, lowercase characters and numbers");
    } else {
        setSuccess(password);
    }

};

