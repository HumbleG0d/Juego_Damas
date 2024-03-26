export default function Button({classNameButon,children}) {
    return (
        <div className="div_button">
             <button className={classNameButon}>{children}</button>
       </div>
    )
}