export default function Campo({ classNameLabel, classNameInput, htmlFor, name, type , register}) {
    
    const boolean = type === 'checkbox' ? false : true
    return (
        <>
            <label className = {classNameLabel} htmlFor = {htmlFor} >{name}</label>
            <input className={classNameInput} type={type} id={htmlFor} {...register(htmlFor, {
                required: {value: boolean, message: `${name.toLowerCase()} es requerido` , ...(type === 'email' && {pattern: {value: /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/, message: 'correo invalido'}})}
            })} />
        </>
    /*TODO: agregar requerimientos para que la contraseña sea de longitud 8 que contenga letra mayuscula , numeros , caracteres */
    )
}