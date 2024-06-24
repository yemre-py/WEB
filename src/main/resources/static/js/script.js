const passwordBtn = document.getElementById("passwordBtn");
const showEye = document.getElementById("showEye");
const hideEye = document.getElementById("hideEye");
const password = document.getElementById("password");

password.addEventListener("focus", (e) => {
    passwordBtn.style.display = "inline-flex";
});

passwordBtn.addEventListener("click", (e) => {
    e.preventDefault();
    let pass = password.getAttribute("type");
    if (pass === "password") {
        showEye.style.display = "none";
        hideEye.style.display = "block";
        password.setAttribute("type", "text");
    } else {
        showEye.style.display = "block";
        hideEye.style.display = "none";
        password.setAttribute("type", "password");
    }
});

// Initial state
showEye.style.display = "block";
hideEye.style.display = "none";
