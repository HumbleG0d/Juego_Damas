export default function Campo({ classNameLabel, classNameInput, htmlFor, name, type , register}) {
    
    const boolean = type === 'checkbox' ? false : true
    return (
        <>
            <label className = {classNameLabel} htmlFor = {htmlFor} >{name}</label>
            <input className={classNameInput} type={type} id={htmlFor} {...register(htmlFor, {
                required: {value: boolean, message: `${name.toLowerCase()} es requerido`}
            })} />
        </>
    
    )
}