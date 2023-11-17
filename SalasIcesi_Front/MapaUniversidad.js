var EdificoId = ['E', 'M', 'B'] ; 

if (window.localStorage.getItem('user') === null) {
    window.location.href = "/registro.html";
} else {
    var user = JSON.parse(window.localStorage.getItem('user'));
}

function manejarClicSalon(event) {
    event.preventDefault();
    var salonSeleccionado = event.target.innerHTML;
    window.localStorage.setItem("Edificio", salonSeleccionado);
    window.location.href = "/SalasIcesi/SalasIcesi_Front/EdificioE_piso1.html";
}

EdificoId.forEach(function (salonId) {
    var salonElemento = document.getElementById(salonId);
    salonElemento.addEventListener('click', manejarClicSalon);
});