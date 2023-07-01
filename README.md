<h1 align="center">Hotel Alura</h1>
El Hotel Alura conocido por su espectaculares instalaciones y paquetes promocionales para Desarrolladores de 
Software está teniendo problemas para llevar el control de las reservaciones hechas por sus clientes, por eso solicitan nuestra ayuda para desarrollar un sistema de reserva que contenga:
<ul>
  <li>Sistema de autenticación de usuario para que solo usuarios pertenecientes al hotel consigan acceder al sistema</li>
  <li>Permitir crear, editar y eliminar una reserva para los clientes</li>
  <li>Buscar en la base de datos todas las informaciones tanto de los clientes como de las reservas</li>
  <li>Registrar, editar y eliminar datos de los huéspedes</li>
  <li>Calcular el valor de la reserva en base a la cantidades de días de la reserva y a una tasa diaria que puede ser asignada por ti y en la moneda local de tu país, por ejemplo si tenemos una reserva de 3 dias y el valor de nuestra diaria son 20$ debemos multiplicar esos 3 dias por el valor de la diaria, lo que serian 60$, todo esto deberá ser hecho automaticamente y mostrado al usuario antes de guardar la reserva</li>
  <li>Base de datos para almacenar todos los datos pedidos anteriormente</li>
</ul>
<h3>Diagrama base de datos</h3>
<p align="center">
  <img src = "https://github.com/brayan-chiquito/Proyecto-hotel-alura/assets/54116336/b70ddc26-63fa-495b-b95f-3d19d184db89">
<p>
<h3>Menu principal</h3>
El menú principal de nuestra aplicación es nuestra presentación, podemos ver que contiene diferentes elementos:
<ul>
  <li>Imagen de wallpaper</li>
  <li>Logo del Hotel</li>
  <li>Botón Login que al ser clickado debe llevar a la ventana de iniciar sesión</li>
  <li>Botón salir que debe preguntar al usuario si realmente desea salir de la aplicación.</li>
</ul>
<p align="center">
  <img src = "https://github.com/brayan-chiquito/Proyecto-hotel-alura/assets/54116336/fa11d254-7a9b-4f99-ad4b-b5ec0b8ec7fd">
<p>
<h3>Login</h3>
<p>Esta ventana debe permitir al usuario ingresar su usuario y contraseña.
Por detrás de la cortina debemos verificar si los datos ingresados son correctos o incorrectos y notificar al usuario de este estatus, por ejemplo si los datos son incorrectos debe ser mostrado una mensaje al usuario diciendo "Usuario y Contraseña inválidos"</p>
<p>usuario predeterminado: admin</p>
<p>contraseña: admin</p>
<p align="center">
  <img src = "https://github.com/brayan-chiquito/Proyecto-hotel-alura/assets/54116336/902c5b11-03aa-46c6-880f-8015203ebbb3">
<p>
