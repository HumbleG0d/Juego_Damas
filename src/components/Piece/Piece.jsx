export default function Piece({ color , onClick}) {
  return (
    <article
      className="pieza"
      style={{
        backgroundColor: color,
      }}
      onClick={onClick}
    ></article>
  );
}