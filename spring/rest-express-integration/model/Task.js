const mongoose=require('mongoose');
const tasks=mongoose.model('Task',{
    
description:{
    type:String,
    trim:true,
    required:true
},
completed:{
    type:Boolean,
    trim:true,
    
}
});
module.exports=tasks;