var a = 0;

const DOM = {
    submitBtn: '.submit-button',
    submitPending: '.submit-button__pending',
    submitText: '.submit-button__text',
    submitLoaded: '.submit-button__loaded' };


const findChildren = elem => {
    return [
        elem.querySelector(DOM.submitPending),
        elem.querySelector(DOM.submitText),
        elem.querySelector(DOM.submitLoaded)];
};

function show(){
    a = a + 1;
    if (a%2==0) {
        document.getElementById('div2').style.display = 'none';
    }else{
        document.getElementById('div2').style.display = 'block';
    }
}

function picture(){
    if (document.getElementById('odtlacok').value = "prva") {
        document.getElementById('fotka1').style.display = 'block';
    }
    if (document.getElementById('odtlacok').value = "druha") {
        document.getElementById('fotka2').style.display = 'block';
    }
    if (document.getElementById('odtlacok').value = "tretia") {
        document.getElementById('fotka3').style.display = 'block';
    }
}

$('#inputGroupSelect02').on('change', function()
{
    if (this.value == "registration"){
        document.getElementById('register').style.display = 'block';
        document.getElementById('register1').style.display = 'none';
        document.getElementById('register2').style.display = 'none';
        document.getElementById('imagepreprocess').style.display = 'none';
    }
    if (this.value == "selected"){
        document.getElementById('register').style.display = 'none';
        document.getElementById('register1').style.display = 'none';
        document.getElementById('register2').style.display = 'none';
        document.getElementById('imagepreprocess').style.display = 'none';
    }
    if (this.value == "verification"){
        document.getElementById('register1').style.display = 'block';
        document.getElementById('register').style.display = 'none';
        document.getElementById('register2').style.display = 'none';
        document.getElementById('imagepreprocess').style.display = 'none';
    }
    if (this.value == "identification") {
        document.getElementById('register').style.display = 'none';
        document.getElementById('register1').style.display = 'none';
        document.getElementById('register2').style.display = 'none';
        document.getElementById('imagepreprocess').style.display = 'none';
    }
    if (this.value == "showing") {
        document.getElementById('register').style.display = 'none';
        document.getElementById('register1').style.display = 'none';
        document.getElementById('register2').style.display = 'none';
        document.getElementById('imagepreprocess').style.display = 'none';
    }
    if (this.value == "preprocessing") {
        document.getElementById('register').style.display = 'none';
        document.getElementById('register1').style.display = 'none';
        document.getElementById('register2').style.display = 'block';
        document.getElementById('imagepreprocess').style.display = 'block';
    }
});

$('#inputGroupSelect01').on('change', function()
{
    if (this.value == "registration"){
        document.getElementById('register0').style.display = 'block';
        document.getElementById('register01').style.display = 'none';
        document.getElementById('register02').style.display = 'none';

    }
    if (this.value == "selected"){
        document.getElementById('register0').style.display = 'none';
        document.getElementById('register01').style.display = 'none';
        document.getElementById('register02').style.display = 'none';

    }
    if (this.value == "verification"){
        document.getElementById('register01').style.display = 'block';
        document.getElementById('register0').style.display = 'none';
        document.getElementById('register02').style.display = 'none';

    }
    if (this.value == "identification") {
        document.getElementById('register0').style.display = 'none';
        document.getElementById('register01').style.display = 'none';
        document.getElementById('register02').style.display = 'none';

    }
    if (this.value == "showing") {
        document.getElementById('register0').style.display = 'none';
        document.getElementById('register01').style.display = 'none';
        document.getElementById('register02').style.display = 'none';

    }
    if (this.value == "preprocessing") {
        document.getElementById('register0').style.display = 'none';
        document.getElementById('register01').style.display = 'none';
        document.getElementById('register02').style.display = 'block';

    }
});

$('#inputGroupSelect03').on('change', function()
{
    if (this.value == "zero"){
        document.getElementById('photo0').style.display = 'block';
        document.getElementById('photo1').style.display = 'none';
        document.getElementById('photo2').style.display = 'none';
        document.getElementById('photo3').style.display = 'none';
        document.getElementById('photo4').style.display = 'none';
        document.getElementById('photo5').style.display = 'none';
    }
    if (this.value == "one"){
        document.getElementById('photo0').style.display = 'none';
        document.getElementById('photo1').style.display = 'block';
        document.getElementById('photo2').style.display = 'none';
        document.getElementById('photo3').style.display = 'none';
        document.getElementById('photo4').style.display = 'none';
        document.getElementById('photo5').style.display = 'none';
    }
    if (this.value == "two"){
        document.getElementById('photo0').style.display = 'none';
        document.getElementById('photo1').style.display = 'none';
        document.getElementById('photo2').style.display = 'block';
        document.getElementById('photo3').style.display = 'none';
        document.getElementById('photo4').style.display = 'none';
        document.getElementById('photo5').style.display = 'none';
    }
    if (this.value == "three") {
        document.getElementById('photo0').style.display = 'none';
        document.getElementById('photo1').style.display = 'none';
        document.getElementById('photo2').style.display = 'none';
        document.getElementById('photo3').style.display = 'block';
        document.getElementById('photo4').style.display = 'none';
        document.getElementById('photo5').style.display = 'none';
    }
    if (this.value == "four") {
        document.getElementById('photo0').style.display = 'none';
        document.getElementById('photo1').style.display = 'none';
        document.getElementById('photo2').style.display = 'none';
        document.getElementById('photo3').style.display = 'none';
        document.getElementById('photo4').style.display = 'block';
        document.getElementById('photo5').style.display = 'none';
    }
    if (this.value == "five") {
        document.getElementById('photo0').style.display = 'none';
        document.getElementById('photo1').style.display = 'none';
        document.getElementById('photo2').style.display = 'none';
        document.getElementById('photo3').style.display = 'none';
        document.getElementById('photo4').style.display = 'none';
        document.getElementById('photo5').style.display = 'block';
    }
});


const findParent = (elem, referenceElem) => {

    const className = referenceElem.slice(0, referenceElem.length);

    let ind = true;

    while (ind) {

        if (elem.classList.contains(className)) {
            break;
        } else {
            elem = elem.parentNode;
        }
    }
    return elem;
};

//onclick function for buttons
document.querySelectorAll(DOM.submitBtn).forEach(elem => {

    elem.addEventListener('click', event => {

        let clickedElem = findParent(event.target, 'submit-button');

        const innerChildren = findChildren(clickedElem);

        //adding active class
        if (!clickedElem.classList.contains('js-active')) {

            clickedElem.classList.add('js-active');

            innerChildren.forEach(elem => {
                elem.classList.add('js-active');
            });

        } else {

            //toggling or restart part
            clickedElem.classList.remove('js-active');

            innerChildren.forEach(elem => {
                elem.classList.remove('js-active');
            });

        }

    });

});