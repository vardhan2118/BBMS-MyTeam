import { Box, Button, Container, Stack, TextField } from "@mui/material";
import axios from "axios";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const AddDonor = () => {
  let navigate = useNavigate();

  const [userData, setUserData] = useState({
    name: "",
    age: "",
    gender: "",
    bloodgroup: "",
    quantity: "",
    contact_no: "",
  });

  const { name, age, gender, bloodgroup, quantity, contact_no } = userData;

  const handleData = (e) => {
    setUserData((prevUserData) => ({
      ...prevUserData,
      [e.target.name]: e.target.value,
    }));
  };

  const submitData = async (e) => {
    e.preventDefault();
    console.log(userData);
    await axios.post(`http://localhost:8080/adduser`, userData);
    setUserData({
      name: "",
      age: "",
      gender: "",
      bloodgroup: "",
      quantity: "",
      contact_no: "",
    });
    navigate("/BasicTable");
  };

  return (
    <Container>
      <Box>
        <form onSubmit={submitData}>
          <Stack spacing={2} marginTop={5} maxWidth={"40vh"}>
            <TextField
              variant="outlined"
              label="Name"
              name="name"
              value={name}
              onChange={handleData}
            />
            <TextField
              variant="outlined"
              label="age"
              name="age"
              value={age}
              onChange={handleData}
            />
            <TextField
              label="gender"
              name="gender"
              value={gender}
              variant="outlined"
              onChange={handleData}
            />
            <TextField
              label="bloodgroup"
              name="bloodgroup"
              value={bloodgroup}
              variant="outlined"
              onChange={handleData}
            />
            <TextField
              label="quantity"
              name="quantity"
              value={quantity}
              variant="outlined"
              onChange={handleData}
            />
            <TextField
              label="contactno"
              name="contact_no"
              value={contact_no}
              variant="outlined"
              onChange={handleData}
            />
            <Stack direction={"row"} spacing={2}>
              <Button type="submit" variant="contained">
                Add Donor
              </Button>
              <Button href="/BasicTable" color="error" variant="contained">
                Cancel
              </Button>
            </Stack>
          </Stack>
        </form>
      </Box>
    </Container>
  );
};

export default AddDonor;
