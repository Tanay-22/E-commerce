import React from 'react'
import MainCarosel from '../../HomeCarosel/MainCarosel'
import HomeSectionCarosel from '../../HomeSectionCarosel/HomeSectionCarosel'

export const HomePage = () => 
{
  return (
    <div>
        <MainCarosel />

        <div>
          <HomeSectionCarosel />
		</div>
    </div>
  )
}
