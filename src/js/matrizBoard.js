// Definir una función para crear un tablero de damas con notación algebraica
export default function crearTablero() {
  const filas = 8;
  const columnas = 8;
  const tablero = [];

  // Iterar sobre las filas
  for (let fila = 1; fila <= filas; fila++) {
    const filaTablero = [];

    // Iterar sobre las columnas
    for (let columna = 1; columna <= columnas; columna++) {
      // Crear la notación algebraica para la casilla (fila-columna)
      const casilla = `${fila}${String.fromCharCode(64 + columna)}`;
      // Añadir la casilla a la fila del tablero
      filaTablero.push(casilla);
    }

    // Añadir la fila al tablero
    tablero.push(filaTablero);
  }

  return tablero;
}
