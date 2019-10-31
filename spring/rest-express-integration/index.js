 const express = require('express')
require('./db/mongoose')
const userRoute = require('./routes/userRoute')


const app = express()
const port = process.env.PORT || 4000

app.use(express.json())
app.use(userRoute)


app.listen(port, () => {
    console.log('Server is up on port ' + port)
})