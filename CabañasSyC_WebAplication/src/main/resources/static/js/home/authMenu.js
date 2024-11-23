function toggleAuthMenu() {
    const authMenu = document.getElementById("authMenu");
    authMenu.classList.toggle("hidden"); 
}


document.addEventListener('click', function (e) {
    const authMenu = document.getElementById("authMenu");
    const button = document.querySelector("button");
    if (!button.contains(e.target) && !authMenu.contains(e.target)) {
        authMenu.classList.add("hidden"); 
    }
});