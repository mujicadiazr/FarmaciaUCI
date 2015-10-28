DELETE FROM Vale WHERE ID = ?;
DELETE FROM Medicamento WHERE Nombre = ? AND Tipo = ?;
DELETE FROM Trabajador WHERE Usuario = ?;
DELETE FROM Suscripcion WHERE CI = ?;
DELETE FROM Vuelta WHERE ID = ?;
DELETE FROM GestionAlmohadillas WHERE VueltaID = ? AND SuscripcionCI = ?;
DELETE FROM VentaMedicamentos WHERE MedicamentoNombre = ? AND MedicamentoTipo = ? AND ValeID = ?;
DELETE FROM Reclamacion WHERE Documentoid = ?;
DELETE FROM Documento WHERE id = ?;
DELETE FROM InformeRecepcion WHERE Documentoid = ?;


