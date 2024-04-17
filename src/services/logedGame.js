import axios from "axios";
const sendData = async (data) => {
  try {
    const response = await axios.post(
      "http://localhost:8080/auth/login",
      data,
      {
        headers: {
          "Content-Type": "application/json",
        },
      }
    );
    if (response.status === 200) {
      alert("Usuario logeado correctamente");
    }
  } catch (error) {
    console.error("Error al enviar los dotas: ", error);
    throw error;
  }
};

export default sendData;
