import Form from "./Form/Form"
import Campo from "./Campo/Campo"
import Button from "./Button/Button"
import '../styles/form.css'
import '../App.css'
import '../styles/form.css'
import {useForm} from 'react-hook-form'

export default function FormLogin() {

  const { register, handleSubmit , formState:{errors} } = useForm()
  
  const onSubmit = handleSubmit((data) => {
    console.log(data)
  })

    return (
        <>
          <Form onSubmit = {onSubmit}>
            <div className="div_campo">
            <Campo classNameInput="form_input" classNameLabel="form_label-id" htmlFor="id" name="NOMBRE DE CUENTA" type="text" register={register} />
            {errors.id && <span className="form_error">{errors.id.message}</span>}
            </div>
            
            <div className="div_campo">
              <Campo classNameInput="form_input" classNameLabel="form_label" htmlFor="password" name="CONTRASEÑA" type="password" register={register}/>            
            {errors.password && <span className="form_error">{errors.password.message}</span>}  
          </div>            
            
            
            <div className="div_campo-2">
              <Campo classNameInput="form_check" classNameLabel="form_check" htmlFor="recordar" name="Recordarme" type="checkbox" register={register}/>    
            </div>
            
            <Button classNameButon="buttonSesion">Iniciar sesión</Button>
              
            <a href="" className="form_enlace">Crear una cuenta gratuita</a>
          </Form>
        </>
    )
}