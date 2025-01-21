document.addEventListener('DOMContentLoaded', () => {
    const activeLinks = document.querySelectorAll('.navLink');
    const windowPath = window.location.pathname;
    const navbar = document.querySelector('.navbar'); // Ajusta el selector a tu contenedor de navbar

    // Cambiar el color de las letras del navbar basado en la URL
    if (navbar) {
        if (windowPath === '/cabins/cabinsList' || windowPath === '/cabins/cabinsList') {
            navbar.classList.add('text-white');
        }else if(windowPath === '/tours/toursList' || windowPath === '/tours/toursList') {
            navbar.classList.add('text-white');
        }
    }

    // Añadir la clase 'page-selected' a los enlaces activos
    activeLinks.forEach((activeLink) => {
        const href = activeLink.getAttribute('href');
        if (href) {
            const navLinkPath = new URL(href, window.location.origin).pathname;
            if (windowPath === navLinkPath || (windowPath === '/' && navLinkPath === '/index')) {
                activeLink.classList.add('page-selected');
            }
        }
    });
});
