import React from 'react';
import {Button, Card, CardContent, styled} from "@mui/material";
import Typography from "@mui/material/Typography";
import trophy from "../../imgSrc/trophy.jpg"


const TriangleImage = styled("img")(
{
    right: 0,
    bottom: 0,
    height: 170,
    position: "absolute"
})

const TrophyImage = styled("img")(
{
    right: 36,
    bottom: 20,
    height: 98,
    position: "absolute"
});


const Achievement = () =>
{
    return (
        <Card sx={{position: "relative"}}>
            <CardContent>
                <Typography variant="h6" sx={{letterSpacing: "0.25px"}}>
                    Shop with DogRaj
                </Typography>
                <Typography>Congratulations🎊🎊</Typography>
                <Typography>500k</Typography>

                <Button size="small" variant="contained">View Sales</Button>

                <TrophyImage src={trophy}/>
            </CardContent>
        </Card>
    );
};

export default Achievement;