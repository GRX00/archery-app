/**
 * Created by Grzegorz.Zebrowski on 2016-06-04.
 */

function addTrailingZeroes(input, constantDigits){
    input.setAttribute('type', 'text');
    if (input.value.length > constantDigits) {
        input.value = input.value.replace(/^0+/, '');
    }
    while (input.value.length < constantDigits) {
        input.value = "0" + input.value;
    }
}

function setSelectedToInput(select) {
    var input = select.nextElementSibling;
    var selectedValue = select.options[select.selectedIndex].value;

    input.value = selectedValue;
}