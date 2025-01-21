document.addEventListener('DOMContentLoaded', function () {
    const sliderItems = document.querySelectorAll('.slider-img');
    const slider = document.querySelector('.slider-images');
    let animationIndex = 0;
    let isAnimating = true;
    let isBouncing = true;
    const bounceClass = 'bounce';

    function addBounceAnimation() {
        const firstItem = sliderItems[0];
        firstItem.classList.add(bounceClass);
    }

    function stopBounceAnimation() {
        const firstItem = sliderItems[0];
        firstItem.classList.remove(bounceClass);
        isBouncing = false;
    }

    function animateSequentially() {
        if (isAnimating && animationIndex < sliderItems.length) {
            const currentItem = sliderItems[animationIndex];
            currentItem.classList.add('active');

            centerImage(currentItem);

            setTimeout(() => {
                currentItem.classList.remove('active');
                animationIndex++;
                animateSequentially();
            }, 2000);
        } else {
            animationIndex = 0;

            if (isBouncing) {
                addBounceAnimation();
            }
        }
    }

    function centerImage(element) {
        const imageWidth = element.offsetWidth;
        const containerWidth = slider.offsetWidth;

        const index = Array.from(sliderItems).indexOf(element);
        const imagePosition = element.offsetLeft;

        const scrollPosition = imagePosition - (containerWidth / 2) + (imageWidth / 2);
        slider.scrollTo({
            left: scrollPosition,
            behavior: 'smooth'
        });
    }

    setTimeout(() => {
        if (isAnimating) {
            animateSequentially();
        }
    }, 1000);

    sliderItems.forEach(item => {
        item.addEventListener('click', () => {
            isAnimating = false;
            if (isBouncing) {
                stopBounceAnimation();
            }

            if (item.classList.contains('active')) {
                item.classList.remove('active');
            } else {
                sliderItems.forEach(slider => {
                    slider.classList.remove('active');
                });
                item.classList.add('active');
            }

            centerImage(item);
        });
        
        
    });
});
