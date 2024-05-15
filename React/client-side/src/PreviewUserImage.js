import React, { useState } from 'react'

export default function PreviewUserImage({file}) {

    const [preview,setPreview] = useState({});

    if(file instanceof Blob ){
        const reader = new FileReader()
        reader.readAsDataURL(file)
        reader.onload = () => {
            setPreview(reader.result)
        }
    }

    return (
        <div>
            <img style={{width : "300px"}} src={preview} alt="" />
        </div>
    )
}