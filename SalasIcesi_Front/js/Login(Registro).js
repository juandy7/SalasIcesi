const username = document.getElementById('username');
const password = document.getElementById('password');
const ingresarId = document.getElementById('IngresarId');

// Verificar si el usuario ya está autenticado antes de mostrar el formulario
if (window.localStorage.getItem('user') !== null) {
  //window.location.href = '/Registro.html';
}

ingresarId.addEventListener('click', async function (event) {
  event.preventDefault();
  let usernameValue = username.value;
  let passwordValue = password.value;

  // Crear el objeto con los datos de inicio de sesión
  let loginUsuarioDTO = {
    email: usernameValue,
    contrasenha: passwordValue,
  };

  let data = JSON.stringify(loginUsuarioDTO);

  try {
    let response = await fetch('http://localhost:8080/salasIcesi/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: data,
    });

    if (response.status === 200) {
      // Almacenar los datos del usuario en el almacenamiento local
      window.localStorage.setItem('user', JSON.stringify(loginUsuarioDTO));
      let responseData = await response.json();
      console.log(responseData);

      // Verificar la categoría y redirigir a la página correspondiente
      if (responseData.categoria === 'ESTUDIANTE' || responseData.categoria === 'PROFESOR') {
        window.location.href = 'MenuPrincipal.html';
      } else if (responseData.categoria === 'ADMINNISTRADOR') {
        window.location.href = 'AdminPrincipal.html';
      } else {
        console.error('Categoría desconocida');
      }
    } else {
      console.error('Error en la autenticación');
    }
  } catch (error) {
    console.error('Error en la solicitud:', error);
  }
});





