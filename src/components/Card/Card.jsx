import { CgClose } from "react-icons/cg";
export default function Card({ title,children , colorB , bgcolor , colorTitle}) {
  return (
    <div class="success" style={{backgroundColor: bgcolor}}>
      <div class="success__icon">{children}</div>
      <div class="success__title" style={{color: colorTitle }}>{title}</div>
      <div class="success__close">
              <CgClose
                  style = {{
                    color: colorB,
                }}
              />
      </div>
    </div>
  );
}
