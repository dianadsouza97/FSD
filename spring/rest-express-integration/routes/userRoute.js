const express=require('express');
const User=require('../model/User');
const router=new express.Router()

router.post('/users', async(req,res)=>{
    const user=new User(req.body);
    try{
        await user.save();
        res.status(201).send(user)
    }catch(e){
        res.status(400).send(e);
    }
})
router.get('/users',async(req,res)=>{
    try{
        const users=await User.find({})
        res.send(users)
    }catch(e){
        res.status(500).send();
    }
})
router.post('/users/login', async (req, res) => {
    try {
        const email=req.body.email;
        const user=await userSchema.findOne({email});
        if(!user){
            throw new Error('Unable to login');
        }
        else{
        const user = await User.findByCredentials(req.body.email, req.body.password);
        }
        console.log("true");
        res.send(user)
    } catch (e) {
        res.status(400).send()
    }
})

module.exports = router
