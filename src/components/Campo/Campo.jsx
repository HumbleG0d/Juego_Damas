export default function Campo({classNameLabel ,classNameInput , htmlFor , name , type}) {
    return (
        <>
            <label className = {classNameLabel} htmlFor = {htmlFor}>{name}</label>
            <input className = {classNameInput} type = {type} />
        </>
    
    )
}