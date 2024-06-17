import React from 'react';

const AddressCard = ({ address }) =>
{
    // console.log(address);
    return (
        <div>
            <div className="space-y-3">
                <p className="font-semibold">{`${address?.firstName} ${address?.lastName}`}</p>
                <p>
                    {`${address?.streetAddress}, ${address?.city} - ${address?.zipCode}`}
                </p>
                <p>
                    {address?.state.toUpperCase()}
                </p>
                <div className="space-y-1">
                    <p className="font-semibold">Phone Number</p>
                    <p>+91-{address?.mobile}</p>
                </div>
            </div>
        </div>
    );
};

export default AddressCard;