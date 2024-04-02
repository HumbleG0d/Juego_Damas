export const validatorRules = {
  text: {
    required: true,
    pattern: {
      value: /^[a-zA-Z0-9_]+$/,
      message: "Invalid username",
    },
    minLength: {
      value: 7,
      message: "Username must be at least 7 characters long",
    },
  },
  email: {
    rquerid: true,
    pattern: {
      value:
        /^[a-z0-9!#$%&\'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&\'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/,
      message: "Invalid email",
    },
  },
  password: {
    requerid: true,
    pattern: {
      value:
        /^(?=.*\d)(?=.*[\u0021-\u002b\u003c-\u0040])(?=.*[A-Z])(?=.*[a-z])\S{8,16}$/,
      message:
        "Password must contain at least one uppercase letter, a number, and a special character",
    },
    minLength: {
      value: 8,
      message: "Password must be at least 8 characters long",
    },
  },
  checkbox: {
    required: true,
    pattern: {
      value: false,
      message: "You must accept the terms and conditions",
    },
  },
};
