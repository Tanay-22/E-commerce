import './App.css';
import { Footer } from './customer/component/Footer/Footer';
import Navigation from './customer/component/Navigation/Navigation';
import Product from './customer/component/Product/Product';
import { HomePage } from './customer/component/pages/homePage/HomePage';
import Tester from './tester';

function App() {
  return (
    <div>
		<Navigation />
		<div>
			{/* <HomePage /> */}
      <Product />
      {/* <Tester /> */}
		</div>
    <Footer />
    </div>

  );
}

export default App;
