/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function modificar(objecto) {
    var padre = objecto.parentNode.parentNode.parentNode.parentNode.parentNode;
    var hijos = padre.childNodes;
    var user = padre.getElementsByTagName("td")[7].Text;
    
    forms[0].usuario.value = user;
    forms[0].accion.value = "modificar";
    forms[0].submit();
}

function eliminar(objecto) {
    var padre = ((((objecto.parentNode).parentNode).parentNode).parentNode).parentNode;
    var hijos = padre.childNodes;
    var user = hijos[7].childNodes[0].text;
    
    alert("lolo " + objecto.parentNode.parentNode.parentNode.parentNode.parentNode.childNodes[1].tagName);
    
    document.getElementsByName("usuario").value = user;
    document.getElementsByName("accion").value = "eliminar";
    document.forms[0].submit();
}

