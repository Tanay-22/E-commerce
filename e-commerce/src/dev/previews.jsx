import {ComponentPreview, Previews} from '@react-buddy/ide-toolbox'
import {PaletteTree} from './palette'
import OrderSummary from "../customer/component/checkout/OrderSummary";

const ComponentPreviews = () =>
{
    return (
        <Previews palette={<PaletteTree/>}>
            <ComponentPreview path="/OrderSummary">
                <OrderSummary/>
            </ComponentPreview>
        </Previews>
    )
}

export default ComponentPreviews