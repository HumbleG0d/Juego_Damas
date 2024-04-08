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

    return response.data;
  } catch (error) {
    console.error("Error al enviar los dotas: ", error);
    throw error;
  }
};

export default sendData;
