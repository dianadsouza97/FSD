const mongoose = require('mongoose');
const course = require('./routes/courseRoute');
const student = require('./routes/studentRoute');
const express = require('express');
const app = express();
mongoose.connect('mongodb://localhost/studentcourse')
  .then(() => console.log('Connected to MongoDB...'))
  .catch(err => console.error('Could not connect to MongoDB...'));
app.use(express.json());
app.use('/api/courses', course);
app.use('/api/students', student);
const port = process.env.PORT || 4000;
app.listen(port, () => console.log(`Listening on port ${port}...`));