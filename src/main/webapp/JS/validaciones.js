function validarFormulario() {

    const nombre = document.getElementById("userName").value.trim();

    document.getElementById("mensaje").innerHTML = "";

    //validar nombre no vacio
	if (nombre === "") {
        document.getElementById("mensaje").innerHTML =
            "Debe ingresar un nombre.";
        return false;
    }

    //validar que el nombre no sean numeros
	if (!/^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$/.test(nombre)) {
        document.getElementById("mensaje").innerHTML =
            "El nombre solo debe contener letras.";
        return false;
    }

    return true;
}