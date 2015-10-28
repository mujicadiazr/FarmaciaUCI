/*
 *By Randy Mujica Diaz
 */
 
function permite(evento, permitidos) {
	// Variables que definen los caracteres permitidos
	var numeros = "0123456789";
	var caracteres = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
	var numeros_caracteres = numeros + caracteres;
	var simbolos = "!@#$%^&*()_+=/><;:\\~\'-\"[]|{},.?\t "
	var numeros_caracteres_simbolos = numeros + caracteres + simbolos;
	var otrasTeclas = [8,46,37,39]; //Teclas para borrar y las flechas alante y atras
	
	// Seleccionar los caracteres en funcion del parametro de la funcion
	switch(permitidos) {
		case 'num':
			permitidos = numeros;
			break;
		case 'car':
			permitidos = caracteres;
			break;
		case 'num_car':
			permitidos = numeros_caracteres;
			break;
		case 'num_car_sim':
			permitidos = numeros_caracteres_simbolos;
			break;
		case 'sim':
                    
                        
			permitidos = sim;
			break;
                    case 'car_sim':
                        permitidos = caracteres + simbolos;
                        break;
	}

	// Obtener la tecla pulsada
	var _evento = evento || window.event;
	var codigoCaracter = _evento.charCode || _evento.keyCode;
	var caracter = String.fromCharCode(codigoCaracter);
	// Comprobar si la tecla pulsada se encuentra en los caracteres permitidos
return permitidos.indexOf(caracter) != -1 || otrasTeclas.indexOf(codigoCaracter) != -1;
}