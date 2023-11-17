var salonIds = ['salon1', 'salon2', 'salon3', 'salon4', 'salon5', 'salon6', 'salon7', 'salon8', 'salon9', 'salon10'];

if (window.localStorage.getItem('user') === null) {
    window.location.href = "/registro.html";
} else {
    var user = JSON.parse(window.localStorage.getItem('user'));
}

function manejarClicSalon(event) {
    event.preventDefault();
    var salonSeleccionado = event.target.innerHTML;
    window.localStorage.setItem("sala", salonSeleccionado);
    window.location.href = "/SalasIcesi/SalasIcesi_Front/HorarioDisponible.html";
}

salonIds.forEach(function (salonId) {
    var salonElemento = document.getElementById(salonId);
    salonElemento.addEventListener('click', manejarClicSalon);
});
