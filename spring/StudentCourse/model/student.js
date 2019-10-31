const mongoose=require('mongoose');
const Joi=require('joi');
const courseSchema=require('../model/course');

const student=mongoose.model('student',new mongoose.Schema({
    sname:{
        type:String,
        required:true
    },
    course:{
        type:courseSchema,
        required:true
    },
    dateOfEnrollment:{
        type:Date,
        required:true
    }
}))
function validateStudent(student) {
    const schema = {
      sname: Joi.string().min(3).max(50).required(),
      courseId:Joi.string().required(),
      dateOfEnrollment:Joi.date().required()
    };
  
    return Joi.validate(student, schema);
  }
  
  exports.Student = student; 
  exports.validate = validateStudent;