import { validatorRules } from "../../js/validatorRules"

export default function Campo({ classNameLabel, classNameInput, htmlFor, name, type, register }) {
    
    const rules = validatorRules[type] 
    
    return (
        <>
            <label className = {classNameLabel} htmlFor = {htmlFor} >{name}</label>
            <input className={classNameInput} type={type} id={htmlFor} {...register(htmlFor , rules)} />
        </>
    )
}