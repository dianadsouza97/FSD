const {Student,validate} = require('../model/student'); 
const {Course} = require('../model/course');
const express = require('express');
const router = express.Router();

router.get('/', async (req, res) => {
  const students = await Student.find().sort('name');
  res.send(students);
});

router.post('/', async (req, res) => {
  const { error } = validate(req.body); 
  if (error) return res.status(400).send(error.details[0].message);

  const course = await Course.findById(req.body.courseId);
  if (!course) return res.status(400).send('Invalid course.');

  let student = new Student({ 
    sname: req.body.sname,
    course: {
      _id: course._id,
      name: course.name
    },
    dateOfEnrollment: req.body.dateOfEnrollment
  });
  student = await student.save();
  
  res.send(student);
});

router.put('/:id', async (req, res) => {
  const { error } = validate(req.body); 
  if (error) return res.status(400).send(error.details[0].message);

  const course = await Course.findById(req.body.courseId);
  if (!course) return res.status(400).send('Invalid genre.');

  const student = await Student.findByIdAndUpdate(req.params.id,
    { 
      sname: req.body.sname,
      course: {
        _id: course._id,
        name: course.name
      },
     
      dateOfEnrollment: req.body.dateOfEnrollment
    }, { new: true });

  if (!student) return res.status(404).send('The student with the given ID was not found.');
  
  res.send(student);
});

router.delete('/:id', async (req, res) => {
  const student = await Student.findByIdAndRemove(req.params.id);

  if (!student) return res.status(404).send('The student with the given ID was not found.');

  res.send(student);
});

router.get('/:id', async (req, res) => {
  const student = await Student.findById(req.params.id);

  if (!student) return res.status(404).send('The student with the given ID was not found.');

  res.send(student);
});

module.exports = router; 
