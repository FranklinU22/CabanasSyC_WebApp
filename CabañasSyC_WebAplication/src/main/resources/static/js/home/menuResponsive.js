function onToggleMenu(e) {
    const navLiks = document.querySelector('.linksSelector');
    const menuSelector = document.querySelector('.menuSelector');
    if (menuSelector.classList.contains('fa-bars')) {
        menuSelector.classList.remove('fa-bars');
        menuSelector.classList.add('fa-xmark');
    } else {
        menuSelector.classList.remove('fa-xmark');
        menuSelector.classList.add('fa-bars');
    }
    navLiks.classList.toggle('top-[-200%]');
}