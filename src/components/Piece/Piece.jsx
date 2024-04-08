export default function Piece({ color}) {
  return (
    <article
      className="pieza"
      style={{
        backgroundColor: color,
      }}
    ></article>
  );
}