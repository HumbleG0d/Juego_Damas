export default function Campo({ classNameLabel, classNameInput, htmlFor, name, type , register}) {
    
    const boolean = type === 'checkbox' ? false : true
    return (
        <>
            <label className = {classNameLabel} htmlFor = {htmlFor} >{name}</label>
            <input className={classNameInput} type={type} id={htmlFor} {...register(htmlFor, {
                required: {
                    value: boolean, message: `${name.toLowerCase()} es requerido`, ...(type === 'email' && { pattern: { value: /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/, message: 'correo invalido' } }), 
                    ...(type === 'password' && {
                        minLength: { value: 8, message: 'La contraseña debe tener al menos 8 caracteres' },
                        pattern: {
                            value: /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[A-Za-z\d!@#$%^&*()_+]{8,}$/,
                            message: 'La contraseña debe contener al menos una letra mayúscula, un número, y un carácter especial'
                        }
                    })
                }
            })} />
        </>
    )
}