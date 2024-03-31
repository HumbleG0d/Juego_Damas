export default function Button({classNameButon,children , onClick}) {
    return (
        <button className={classNameButon} onClick={onClick}>{children}</button>
    )
}