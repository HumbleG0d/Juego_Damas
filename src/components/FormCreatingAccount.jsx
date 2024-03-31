import Form from "./Form/Form"
import Campo from "./Campo/Campo"
import Button from "./Button/Button"
import "../styles/normalize.css"
import "../styles/form.css"
import { useForm } from "react-hook-form"

export default function FormCreatingAccount () {
  const { register, handleSubmit, formState: { errors } } = useForm()

  const onSubmit = handleSubmit((data) => {
    console.log(data)
  })

  return (
        <div className="div_form form-container1">
             <Form onSubmit = {onSubmit} className={"form2"}>
            <h1>CREAR CUENTA</h1>
            <div className="input-group">
                <Campo classNameInput="form_input" classNameLabel="form_label-id" htmlFor="correo" name="Direccion de correo electronico" type="email" register={register} />
                {errors.correo && <span className="form_error">{errors.correo.message}</span>}
            </div>

            <div className="input-group">
                <Campo classNameInput="form_input" classNameLabel="form_label" htmlFor="correo1" name="Confirma tu dirección" type="email" register={register}/>
                {errors.correo1 && <span className="form_error">{errors.correo1.message}</span>}
            </div>

            <div className="div_campo-check">
              <Campo classNameInput="form_check-i" classNameLabel="form_check-l" htmlFor="recordar" name="Tengo 13 años o más y acepto los terminos y condiciones" type="checkbox" register={register}/>
            </div>

            <div className="div_campo-select">
                <label className="form_label" htmlFor="pais">País de residencia
                </label>
                <select className="form_select" id="pais" {...register("pais", {
                  required: { value: true, message: "pais es requerido", defaultValue: "Perú" },
                })}>
                    <option value="peru">Perú</option>
                    <option value="argentina">Argentina</option>
                    <option value="brasil">Brasil</option>
                    <option value="chile">Chile</option>
                    <option value="colombia">Colombia</option>
                    <option value="mexico">Mexico</option>
                    <option value="uruguay">Uruguay</option>
                </select>

            </div>

            <Button classNameButon="buttonSesion">Continuar</Button>

          </Form>
        </div>
  )
}
