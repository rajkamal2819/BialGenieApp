package com.Hackathon.bialgenieapp.Database;

import com.Hackathon.bialgenieapp.Models.FAQ_db;
import com.azure.data.tables.TableClient;
import com.azure.data.tables.TableClientBuilder;
import com.azure.data.tables.TableServiceClient;
import com.azure.data.tables.TableServiceClientBuilder;
import com.azure.data.tables.models.TableEntity;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Create_FAQ_Table {



    public static void main(String[] args) {
        final String connectionString =
                "DefaultEndpointsProtocol=https;AccountName=bialtable;AccountKey=wRCVF2troxwyrE9pieQU0tjN84QSOwnq0ybCZBg+b76/EIUD3xFmM2p19Dn8hiIyKWGs1gPAm5cyKhHxh2y7oA==;EndpointSuffix=core.windows.net";


        try
        {
            final String tableName = "Employees";

            // Create a TableServiceClient with a connection string.
            TableServiceClient tableServiceClient = new TableServiceClientBuilder()
                    .connectionString(connectionString)
                    .buildClient();

            // Create the table if it not exists.
            TableClient tableClient = tableServiceClient.createTableIfNotExists(tableName);

        }
        catch (Exception e)
        {
            // Output the stack trace.
            e.printStackTrace();
        }







        List<FAQ_db> dataholder = new ArrayList<>();

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "What are the F&amp;B options at BLR Airport? ",
                "Indulge in a flavourful journey by choosing from an array of F&B options at BLR Airport. With over 44 F&B outlets, operational round the clock, BLR Airport has both Indian and International gourmet cuisines on offer. Passengers and visitors have the option to explore the variety of restaurants at the Kerb and The Quad by BLR, as well."));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "Do you have outlets serving only vegetarian food?",
                "Once past security check, Tiffin Express in the Domestic boarding gates area (near Gate #2 and Gate #23) offers vegetarian food. Besides, there are several outlets on the Kerb and at The Quad by BLR serving only vegetarian food, such as Aubree, Bharatiya Jalpan, Nandi Upachar, Ooru Canteen, among others. Most restaurants have an array of vegetarian food on offer"));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "How safe is it to eat at the Airport? Do Chefs ? staff follow safety protocols?",
                "Heightened safety measures have been introduced to ensure that F&B outlets are safe for passengers. In addition to superior training of hygiene standards for all staff, including temperature screening before and after every shift, staff are equipped with masks and gloves and have been trained to maintain a safe distance while attending to customers. Cutlery and crockery are sterilised after every use. The tables are sanitised after every use and outlets are disinfected frequently. "));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "Is seating allowed or is it take-away only? Can I pre-order my meal?",
                "Seating is allowed at the restaurants, ensuring social distance is maintained. All F&B outlets have contactless options to help travellers avoid human contact at outlets and eliminate queues by pre-ordering by using the ‘FSTR by BLR’ (put link here) tab on the Airport website or through self-ordering FSTR kiosks or by scanning the QR code displayed across the Terminal, with an option to have it delivered at a location of choice at the Terminal, including a specific  boarding gate. Payments, too, can be made digitally at the time of placing the order. Food is packed in hygienic, biodegradable containers that could easily be carried into the aircraft. "));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "What is The QuadbyBLR? ",
                "The Quad by BLR is a retail and F&B plaza at BLR Airport, situated off the Kerb, opposite Arrivals. This space is open for passengers and visitors to indulge in retail therapy, grab a meal, drink their favourite brew, watch match screenings, live music gigs and more."));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "Till what time are the outlets on the kerb open? Is it open for both passengers &amp; visitors?",
                "The outlets at the kerb are operational round the clock for both passengers and visitors.  "));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "Is there a brewery at BLR Airport? Do restaurants serve alcohol? ",
                "There are several outlets at The Quad by BLR that serve alcohol, including Barley & Grapes Café and Windmills Brewery. Alcohol is available between 11:00 AM - 11:00 PM. In addition, Living Liquidz and La Cave sell a selection of liquor and wine. "));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "What shopping options are available at BLR Airport? Share the list of brands",
                "A variety of local and global brands are available at BLR Airport both at domestic and international departures and arrivals, as well as at The Quad by BLR."));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "How do you ensure safety protocols are followed at all retail outlets?",
                "All retail stores follow stringent hygiene measures, including fumigation and sanitisation. Both staff and passengers are screened at entry and safe distance is ensured. All materials are moved to the stores after thorough sanitisation. Passengers are encouraged to use digital modes of payment.   "));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "Where can I get details of the Duty-Free store at BLR Airport?",
                "contact the Duty Manager on +91 90081 11881. The Duty-Free shops, operated by Dufry India, are located at International Arrivals and Departures, and offer over 10,000 products, including cosmetics, fragrances, chocolates, liquor and more.     "));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "How many lounges do you have at the Airport? Do the lounges have free Wi-Fi?",
                "Lounges are available in domestic and international areas. Passengers can enjoy a variety of F&B options along with interactive live food counters. Well-designed seating space, business centre as well as unlimited high-speed Wi-Fi are on offer. The lounges at BLR Airport are operated by Travel Food Services. The lounges are currently being upgraded; therefore, limited space is available."));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "Is the lounge operational currently? How can I access it? ",
                "Both lounges (domestic + international) are operational round-the-clock at BLR Airport. Passengers can access the lounge using eligible lounge cards like VISA, Mastercard, RuPay, Diners, American Express, Lounge Key, Lounge Club, Priority Pass and Airline invitation cards. Contact numbers: Domestic lounge: +91 86575 41675 | International lounge: +91 86575 41678 "));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "What safety procedures are undertaken at the lounges to maintain hygiene?",
                "The lounges are disinfected frequently, and passenger touchpoints are sanitised after every use. The lounges follow FSSAI, HACCP and ISO standards. The staff and passengers are screened at entry. Staff are equipped with masks and gloves. Occupancy at the lounge has been reduced to ensure safe distance. Digital menus and serviced buffet are available for the safety of passengers. "));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "What is the duration to access the lounge?",
                "Passengers may enter the lounge only three hours prior to departure time and are permitted to spend three hours on a single transaction. In case a passenger wants to extend the duration, they need to approach the reception with their requirements."));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "What food options do you serve at the lounge?",
                "Post COVID-19, the lounges offer live food counters for dining, as well as takeaway food box options. The cuisine on offer includes a mix of Indian and Continental food, along with beverages.  "));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "Do the lounges serve alcohol?",
                "Yes, the lounges offer a variety of liquor options at an additional charge.  "));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "What are the transport options available to reach BLR Airport?",
                "Airport Taxis (Meru, Mega and KSTDC Cabs) https://www.meru.in/ |  http://www.megacabs.com/  | https://www.kstdc.co/  \n" +
                        "BMTC Bus Service https://mybmtc.karnataka.gov.in/\n" +
                        "App-based Taxis (Ola/ Uber) "));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "What are the parking charges at BLR Airport?",
                "Two-wheeler\n" +
                        "\n" +
                        "Upto 1 hour: ₹ 40. Every additional hour ₹ 20.\n" +
                        "24 hours: ₹ 250. Every additional day ₹ 150.\n" +
                        "Four-wheeler\n" +
                        "\n" +
                        "Upto 30 minutes: ₹ 100. Every additional hour ₹ 50.\n" +
                        "24 hours: ₹ 600. Every additional day ₹ 350.\n" +
                        "For more information, please visit our website Transport for Travellers | BIAL (bengaluruairport.com)  "));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "How many car parking bays do you have at the Airport? ",
                "Over 900 car parking slots are currently available at the P4 parking area. "));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "Is the parking facility manual or automated?",
                "The automated parking facility for passengers with self-driven cars is entirely contactless from entry to exit. Once the car arrives at the parking gate, the ticket machine dispenses a ticket, capturing the time, date. At the exit, the passenger needs to scan the ticket against a machine, and payment can be made using a digital platform. In case of card payment, the card will be sanitised before returning it to the customer.  "));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "Which taxi services are operating from/ to BLR Airport, and how can I pre-book the facility?",
                "Passengers can pre-book taxis by calling the call centre of the concerned cab operator or through their websites\n" +
                        "\n" +
                        "Airport Taxis\n" +
                        "Meru Cabs – 080-4422-4422 | https://www.meru.in/\n" +
                        "Mega Cabs – 080 47474747 | http://www.megacabs.com/\n" +
                        "KSTDC 080- 4466 4466 | https://www.kstdc.co/  \n" +
                        "App-based Taxis (Ola/ Uber) can be booked through their respective apps."));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "Are toll charges included in my taxi fare?",
                "Passengers will get printed bill with a line item of Rs. 95/- as toll charges in all Airport Taxis. For app-based taxi services, passengers are requested to verify directly with the service. "));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "Are AC buses (Vayu Vajra) operational? What are the timings &amp; routes?",
                "At present, BMTC is operating select routes. Please login to www.mybmtc.com for details on the updated schedule."));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "Are the long distance KSRTC buses operational currently?\n",
                "Currently KSRTC Flybus is operational only between BLR Airport and Mysuru. Please login to www.ksrtc.in  for details on the updated schedule. "));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "Are two-wheelers & cycles allowed at the Airport premises?\n",
                "Two-wheelers are permitted within the Airport campus with designated parking areas on offer. BLR Airport campus is open to cyclists every Sunday between 0600 and 0930 hours. Historically, the movement of cyclists at BLR Airport campus was restricted due to safety concerns. Having improved its road infrastructure, BLR Airport is now welcoming cyclists."));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "Is it possible to park my car at the Airport if I go on a short trip?\n",
                "Day and long-term parking facilities are available for passengers with self-driven vehicles. For details on parking charges, visit https://www.bengaluruairport.com/travellers/transport-parking.html#parking"));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "Is there a cab service for women only passengers? What’s the fare?\n",
                "Pink Taxi by KSTDC and BLRAirport is an initiative for women passengers to travel to and from the Airport. Available 24X7, the taxis are equipped with safety features such as GPRS tracking and an SOS switch for your safety.\n" +
                        "\n" +
                        "Fare:\n" +
                        "\n" +
                        "0600 hours to 2359 hours - ₹ 21.50 per km\n" +
                        "0001hours to 0559 hours - ₹ 23.50 per km "));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "Are there self-drive/ car rental service available at BLR Airport?\n",
                "Carzonrent and WTi Cabs operate car rental services at BLR Airport. For information, visit https://www.bengaluruairport.com/travellers/transport-parking.html#carRentals"));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "Where are the Uber & Ola taxi services located at the Airport?\n",
                "Signage for app-based taxis will guide passengers and visitors to the taxi boarding area, which is a short walk from the Terminal. The Uber boarding point is opposite Arrivals, while the Ola boarding point is next to the BMTC bus station. "));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "How are hygiene and safety measures maintained in taxis?\n",
                "We ensure that the taxis are sanitised, and the drivers are screened before every trip to eliminate all chances of infection. Drivers have been instructed to maintain a safe distance. They are encouraged to use hand sanitiser and face masks to make the car a safe space. Able-bodied passengers are advised to load their luggage into the car without driver assistance. For elderly citizens and passengers with reduced mobility, drivers will assist with luggage while following hygiene measures. Masks are mandatory for both drivers as well as passengers. Passengers without masks would not be allowed to board the taxi. Drivers are screened before arriving at the Airport pick-up zone to ensure passenger safety; they are de-rostered if a fever is detected."));

        dataholder.add(new FAQ_db("General",String.valueOf(dataholder.size())
                ,
                "Are taxis, private vehicles and public transport services to and from Airport allowed during night curfew\n",
                "Movement of taxis, private vehicles and public transport services are allowed to and from Airport. The movement will be allowed only on displaying valid travel documents and strictly adhering to COVID appropriate behaviour.  "));







        //-------------COVID--------------

        dataholder.add(new FAQ_db("Covid",String.valueOf(dataholder.size())
                ,
                "What are the latest travel guidelines for international passengers arriving in Karnataka?\n",
                "As per the GoI circular dated January 7, 2021, the following guidelines must be followed:\n" +
                        "\n" +
                        "PRE-BOARDING\n" +
                        "\n" +
                        "Passengers must submit complete and factual information in self-declaration form on the Air Suvidha portal (www.newdelhiairport.in) before scheduled travel, including last 14 days travel details\n" +
                        "Upload a negative COVID-19 RT-PCR report; test must be conducted within 72 hrs prior to the journey. A declaration with respect to authenticity of the test report is mandatory.\n" +
                        "Upload the vaccination certificate and mention the date of final dose of vaccination.\n" +
                        "Only asymptomatic travellers will be allowed to board after thermal screening\n" +
                        "Passengers must download Aarogya Setu app on their mobile phones\n" +
                        "Passengers must give an undertaking on the portal or otherwise to the MoCA (GoI) through the Airline that they would abide by the decisions of the appropriate Govt authorities to undergo home/institutional quarantine/self-health monitoring, as warranted.\n" +
                        "Passengers originating or transiting from at risk-countries shall be informed by the airlines that they will undergo post arrival testing, quarantine if tested negative, stringent isolation protocols if tested positive\n" +
                        "International passengers arriving from or having visited 'Countries at Risk' must pre-book their RT-PCR test on Air Suvidha portal. Airlines will verify the pre-booking of test prior to boarding. Passengers facing any difficulty in pre-booking will be accompanied by airline staff to the registration counter at the Airport for testing.\n" +
                        "ARRIVAL AT BLR AIRPORT\n" +
                        "Passengers have to undergo Thermal screening (if found symptomatic, will be isolated as per protocol) \n" +
                        "The online self-declaration form shall be shown to the Airport Health Officials \n" +
                        "Passengers coming from Countries at risk viz Countries in Europe including UK, South Africa, Brazil, Botswana, China, Ghana, Mauritius, New Zealand, Zimbabwe, Tanzania, Hong Kong, Israel, Congo, Ethiopia, Kazakhstan, Kenya, Nigeria, Tunisia and Zambia must follow the below: \n" +
                        "Submission of swab sample for post arrival COVID-19 test at the point of arrival (self-paid). Wait for results at the airport before exiting the Terminal or taking a connecting flight\n" +
                        "If tested negative, follow home quarantine for 7 days. Retest on 8th day of arrival. Upload results on Air Suvidha portal to be monitored by respective States. If negative, self-monitor health for the next 7 days\n" +
                        "If tested positive, samples will be sent for genomic testing; sent to a separate isolation facility for treatment as per standard protocol\n" +
                        "Passengers coming from Countries (of origin of flight) other than the countries at risk, listed above, will be allowed to leave the airport. 2% of the passengers shall undergo random testing at airport on arrival. Such travellers shall be escorted by the concerned airlines to testing area on arrival. The cost of testing of such travellers will be borne by BIAL. All passengers shall undergo home quarantine for 7 days and undertake RT-PCR test on 8th day of arrival. Upload results on Air Suvidha portal to be monitored by respective States. If negative, self-monitor health for the next 7 days. \n" +
                        "Note: Children under the age of 5 years are exempted from pre and post arrival testing. However, if found symptomatic for COVID-19 on arrival, or during home quarantine period, they shall undergo testing and will be treated as per State protocol.\n" +
                        "For updated information on countries at risk, as specified by Govt. of India, visit www.mohfw.gov.in\n" +
                        "Passenger shall pre-register and pre-pay for their RTPCR test on arrival by self-registering at  aurigaresearch.in\n"));

        dataholder.add(new FAQ_db("Covid",String.valueOf(dataholder.size())
                ,
                "What are the state-wise regulations for passengers departing from Bengaluru?\n",
                "State governments have announced various protocols for arriving passengers. Please check with your airline about state-specific guidelines before you fly. For updated information click on the links below.\n" +
                        "\n" +
                        "Indigo: https://www.goindigo.in/information/state-regulations.html\n" +
                        "SpiceJet: https://www.spicejet.com/HealthProtocol.aspx\n" +
                        "AirAsia: https://www.airasia.co.in/customer-support#covid\n" +
                        "Air Vistara: https://www.airvistara.com/in/en/coronavirus-update\n" +
                        "GoAir: https://www.flygofirst.com/travel-information/state-wise-guidelines/\n" +
                        "StarAir: https://www.starair.in/Declaration/StateWiseregulation\n" +
                        "Trujet: https://www.trujet.com/#/home"));

        dataholder.add(new FAQ_db("Covid",String.valueOf(dataholder.size())
                ,
                "What are the latest travel guidelines for passengers arriving from Maharashtra?\n",
                "As per the GoK circular dated September 1, 2021, the following guidelines will be ensured for all passengers arriving from Kerala:\n" +
                        "\n" +
                        "Employees & Students\n" +
                        "\n" +
                        "Must carry a negative RT-PCR report not older than 72 hours, irrespective of the vaccination status.\n" +
                        "Mandatory Institutional Quarantine (IQ) for seven days. On the seventh day, RT-PCR test will be conducted. If positive - shifted to a CCC. If negative - released from IQ.\n" +
                        "Arrangements for IQ for students and employees will be done by Admin/Principal of the educational institution and respective companies.  \n" +
                        "Other passengers\n" +
                        "\n" +
                        "Passengers apart from employees and students must produce a negative RT-PCR report not older than 72 hours.\n" +
                        "Mandatory Home Quarantine (HQ) for seven days.\n" +
                        "The following categories are exempted from Institutional Quarantine:\n" +
                        "Children below 2 years\n" +
                        "During an emergency (death in family/ medical treatment, etc)\n" +
                        "Constitutional functionaries, healthcare professionals and their spouses\n" +
                        "Students arriving for exams along with one parent (within 3 days)\n" +
                        "Transit passengers \n" +
                        "Short term travellers  (within 3 days)\n" +
                        "As per the GoK circular dated November 28, 2021, a negative RT-PCR report not older than 72 hours is mandatory - irrespective of vaccination status - for passengers arriving from Maharashtra. The document will be verified by the airline staff at the time of boarding. The following categories are exempted from displaying a negative RT-PCR report:\n" +
                        "\n" +
                        "Children below 2 years\n" +
                        "During an emergency (death in family/ medical treatment, etc), the passenger’s swab will be collected on arrival. Once the RT-PCR test report is available, further action will be taken as per State protocol\n" +
                        "Constitutional functionaries and healthcare professionals\n" +
                        "Short-term travellers  (2 days or less)\n" +
                        "As per the GoK circular dated Nov 8, 2021, short-term travellers  (2 days or less), from Maharashtra must: \n" +
                        "\n" +
                        "be asymptomatic and give a self-declaration on the same while boarding\n" +
                        "undergo mandatory thermal screening on arrival\n" +
                        "carry covid-19 vaccination certificate for completing two doses  \n" +
                        "produce a valid return ticket\n" +
                        "wear mask & follow COVID-19 appropriate behaviour throughout their time in Karnataka\n" +
                        "Negative RT-PCR report is not required for short-term travellers (2 days or less).  \n" +
                        " \n" +
                        "As per GoK circular dated Nov 23, 2021, passengers returning to their hometown in Karnataka from Maharashtra within two days of stay in Maharashtra must comply to the following guidelines:\n" +
                        "should have two doses of COVID-19 vaccination certificate & 14 days should have lapsed after the second dose\n" +
                        "shall be free of COVID-19 symptoms of COVID-19\n" +
                        "shall self-monitor health for 7 days on return\n" +
                        "produce a valid ticket of both to & fro journey to ensure 2 days of stay in Maharashtra      \n" +
                        "Negative RT-PCR report is not required. "));

        dataholder.add(new FAQ_db("Covid",String.valueOf(dataholder.size())
                ,
                "What are the travel guidelines for passengers arriving from Kerala?\n",
                "As per the GoK circular dated September 1, 2021, the following guidelines will be ensured for all passengers arriving from Kerala:\n" +
                        "\n" +
                        "Employees & Students\n" +
                        "\n" +
                        "Must carry a negative RT-PCR report not older than 72 hours, irrespective of the vaccination status.\n" +
                        "Mandatory Institutional Quarantine (IQ) for seven days. On the seventh day, RT-PCR test will be conducted. If positive - shifted to a CCC. If negative - released from IQ.\n" +
                        "Arrangements for IQ for students and employees will be done by Admin/Principal of the educational institution and respective companies.  \n" +
                        "Other passengers\n" +
                        "\n" +
                        "Passengers apart from employees and students must produce a negative RT-PCR report not older than 72 hours.\n" +
                        "Mandatory Home Quarantine (HQ) for seven days.\n" +
                        "The following categories are exempted from Institutional Quarantine:\n" +
                        "Children below 2 years\n" +
                        "During an emergency (death in family/ medical treatment, etc)\n" +
                        "Constitutional functionaries, healthcare professionals and their spouses\n" +
                        "Students arriving for exams along with one parent (within 3 days)\n" +
                        "Transit passengers \n" +
                        "Short term travellers  (within 3 days)"));

        dataholder.add(new FAQ_db("Covid",String.valueOf(dataholder.size())
                ,
                "What are the travel guidelines for passengers arriving from Goa?\n",
                "As per the GoK circular dated January 5, 2022, passengers arriving from Goa must carry a negative RT-PCR report not older than 72 hours. This is also applicable for passengers boarding connecting flights from Goa. The negative report will be verified by the airline staff.  \n" +
                        " \n" +
                        "The following categories are exempted from the RT-PCR report:\n" +
                        "Children below 5 years\n" +
                        "During an emergency (death in family/ medical treatment, etc), swab sample will be collected on arrival\n" +
                        "Constitutional functionaries and healthcare professionals"));


        dataholder.add(new FAQ_db("Covid",String.valueOf(dataholder.size())
                ,
                "When will scheduled international flight operations resume?\n",
                "As per the DGCA circular, all scheduled international commercial passenger flight services to and from India will remain suspended till 2359 hours on January 31, 2021. This restriction is not applicable to Air Bubble flights, cargo operations and flights specifically approved by DGCA."));


        dataholder.add(new FAQ_db("Covid",String.valueOf(dataholder.size())
                ,
                "Is there an option to pre-book the RT-PCR test at BLR Airport?\n",
                "Passengers can pre-book a slot and pay in advance for the RT-PCR test at BLR Airport by logging in to the link below :\n" +
                        "\n" +
                        "COVID19 Testing Center at Kempegowda International Airport (aurigaresearch.com)"));


        dataholder.add(new FAQ_db("Covid",String.valueOf(dataholder.size())
                ,
                "How can international passengers access Wi-Fi without roaming/local sim card to stay connected with their friends & family?\n",
                "Contactless Wi-Fi coupon dispensing kiosks are placed at International arrivals. \n" +
                        "Steps to follow: \n" +
                        "\n" +
                        "Scan the photo page of your passport \n" +
                        "Scan your boarding pass \n" +
                        "Accept terms & conditions \n" +
                        "Collect your Wi-Fi voucher code "));


        dataholder.add(new FAQ_db("Covid",String.valueOf(dataholder.size())
                ,
                "Where can I get more information on COVID-19?\n",
                "Please contact: Ministry of Health & Family Welfare’s\n" +
                        "24X7 helpline +91-11-23978046\n" +
                        "or\n" +
                        "email: ncov2019@gmail.com"));



        //-------------------Others------------------

        dataholder.add(new FAQ_db("Other",String.valueOf(dataholder.size())
                ,
                "What is an Air Bubble flight?\n",
                "An Air bubble is a bilateral arrangement between two countries where airlines from both countries can operate international flights with a set of regulations and restrictions."));

        dataholder.add(new FAQ_db("Other",String.valueOf(dataholder.size())
                ,
                "What are the eligibility criteria for passengers to travel on Air Bubble flights?\n",
                "Information for passengers flying during the pandemic can be accessed on the IATA website - www.iata.org/covid-travel . Check out the global travel regulations map by IATA. Passengers are advised to verify the information with the respective airlines."));

        dataholder.add(new FAQ_db("Other",String.valueOf(dataholder.size())
                ,
                "What are the current travel restrictions on international flights from India?\n",
                "Please refer to the webpage of Bureau of Immigration, Ministry of Home Affairs, GoI for updated schedule - https://boi.gov.in/content/advisory-travel-and-visa-restrictions-related-covid-19-1\n" +
                        "\n" +
                        "In addition, the table below will direct you to the updated information. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "   Country \tUseful Links\n" +
                        "United Kingdom\t\n" +
                        "https://www.gov.uk/foreign-travel-advice/india\n" +
                        "\n" +
                        "France\thttps://in.ambafrance.org/COVID-19-Conditions-for-entering-France#s-Arrivals-from-India-Argentina-Bangladesh-Brazil-Chile-Nepal-Pakistan-nbsp\n" +
                        "UAE\thttps://u.ae/en/information-and-services/justice-safety-and-the-law/handling-the-covid-19-outbreak/travelling-amid-covid-19\n" +
                        "Germany\thttps://india.diplo.de/in-en\n" +
                        "https://india.diplo.de/in-en/vertretungen/coronavirus/2434804\n" +
                        "Maldives\thttps://visitmaldives.com/en/covid19-updates\n" +
                        "Singapore\thttps://safetravel.ica.gov.sg/\n" +
                        "https://www.mfa.gov.sg/Overseas-Mission/New-Delhi/Mission-Updates/2021/05/Updates-to-border-controls\n" +
                        "Qatar\thttps://www.visitqatar.qa/en/plan-your-trip/travel-tips\n" +
                        "https://covid19.moph.gov.qa/en/Pages/default.aspx\n" +
                        "Oman\thttps://www.omanairports.co.om/news/update-on-travel-restrictions-related-to-covid-19/\n" +
                        "Kuwait\thttps://www.kuwaitairways.com/en/information/usefulinfo/Pages/Covid19-Safety-Information.aspx\n" +
                        "Saudi Arabia\thttps://www.visitsaudi.com/en/covid-19-information-page\n" +
                        "USA\t\n" +
                        "https://travel.state.gov/content/travel/en/traveladvisories/ea/covid-19-information.html#ExternalPopup\n" +
                        "Sri Lanka\thttps://www.srilanka.travel/helloagain/\n" +
                        "Japan\t\n" +
                        "https://www.mofa.go.jp/ca/fna/page4e_001053.html\n" +
                        "\n" +
                        "Malaysia\thttps://mtp.imi.gov.my/myTravelPass/main\n" +
                        "Bahrain\thttps://www.bahrainairport.bh/covid-19-travel-information\n"));

        dataholder.add(new FAQ_db("Other",String.valueOf(dataholder.size())
                ,
                "How many Air Bubble flights are operating from BLR Airport?\n",
                "Following Airlines are currently operating AirBubble/repatriation flights from BLR Airport (subject to change):  \n" +
                        "\n" +
                        "Lufthansa Airlines \n" +
                        " 1800 102 5838                \t https://www.lufthansa.com/us/en/travelling-and-corona                           \n" +
                        "Air France/KLM\n" +
                        "1800 4192 033/+91 124 623 3502\n" +
                        "https://www.airfrance.in/IN/en/local/resainfovol/meilleuresoffres/travelrestrictions.htm\n" +
                        "\n" +
                        "https://www.klm.com/travel/jp_en/prepare_for_travel/up_to_date/coronavirus.htm\n" +
                        "Etihad\n" +
                        "1800 123 3901\n" +
                        "https://www.etihad.com/en-in/travel-updates/all-destinations-travel-guides\n" +
                        "Air India\n" +
                        "1860-233-1407 / 0124-264-1407/ 020-2623-1407             \n" +
                        "\n" +
                        "https://www.airindia.in/images/pdf/Covid19-Countrywise-TravelAdvisories.pdf\n" +
                        "\n" +
                        "http://www.airindia.in/COVID-19-UPDATED.htm\n" +
                        "\n" +
                        "IndiGo\n" +
                        "+91 0124 617 3838 / +91-9910383838\n" +
                        "https://www.goindigo.in/information/state-regulations.html\n" +
                        "\n" +
                        "https://www.goindigo.in/information/international-travel-guidelines.html\n" +
                        "British Airways\n" +
                        "1860 180 3592\n" +
                        "https://www.britishairways.com/en-gb/information/incident/coronavirus/latest-information\n" +
                        "Emirates\n" +
                        "+91 91670 03333\n" +
                        "https://www.emirates.com/in/english/help/covid-19/dubai-travel-requirements/tourists/\n" +
                        "GoAir\n" +
                        "1800 2100 999 / +91 22 6273 2111 / 080-22012001\n" +
                        "https://www.goair.in/travel-information/covid-19-updates/covid-19-travel-faqs/\n" +
                        "Malaysia Airlines\n" +
                        " 1 300 88 3000 / +603 7843 3000\n" +
                        "https://www.malaysiaairlines.com/in/en/advisory/travel-information.html\n" +
                        "Qatar Airways\n" +
                        "+91 79 6155 6000, +91-79 4021 6698\n" +
                        "https://www.qatarairways.com/en/travel-alerts/COVID-19-update.html\n" +
                        "Vistara\n" +
                        "+91 9289228888\n" +
                        "https://www.airvistara.com/in/en/coronavirus-update\n" +
                        "Singapore Airlines\t+91 80 4644 5100\t\n" +
                        "https://www.singaporeair.com/en_UK/sg/travel-info/precautionary-measures/\n" +
                        "\n" +
                        "Saudi Arabian Airlines\t0091-80-22114786 / 22114787 / 22114788\thttps://www.saudia.com/covid-19\n" +
                        "Oman Air\t91 2262729000/ 91 1149970000\thttps://www.omanair.com/ae/en/travel-advisory-covid-19-coronavirus-outbreak\n" +
                        "Kuwait Airways\t91-80-41755552\thttps://www.kuwaitairways.com/en/information/usefulinfo/Pages/Covid19-Safety-Information.aspx\n" +
                        "FlyDubai\t+91 11 41504441\thttps://www.flydubai.com/en/plan/covid-19/travel-requirements?gclid=EAIaIQobChMIq_uqu7rG8AIVWjErCh1hQQzVEAAYASAAEgIlZvD_BwE#pcr-indian-subcontinent\n" +
                        "Sri Lankan Airlines\t91 2271279158\t\n" +
                        "https://www.srilankan.com/en_uk/coporate/covid-update\n" +
                        "\n" +
                        "Japan Airlines\t1800-102-4135\thttps://www.jal.co.jp/jp/en/info/2020/inter/201227/\n" +
                        " \n" +
                        "\n" +
                        "For further details, please refer to the website of Ministry of Civil Aviation, India https://www.civilaviation.gov.in/en/about-air-transport-bubbles"));




        for(int i=0;i<dataholder.size();i++){
            try
            {
                final String tableName = "FAQ";

                // Create a TableClient with a connection string and a table name.
                TableClient tableClient = new TableClientBuilder()
                        .connectionString(connectionString)
                        .tableName(tableName)
                        .buildClient();

                // Create a new employee TableEntity.
                String partitionKey = dataholder.get(i).getPartisionkey();
                String rowKey = dataholder.get(i).getRowkey();
                Map<String, Object> personalInfo= new HashMap<>();
                personalInfo.put("Question", dataholder.get(i).getQ());
                personalInfo.put("Answer", dataholder.get(i).getAns());

                TableEntity faq = new TableEntity(partitionKey, rowKey).setProperties(personalInfo);

                // Upsert the entity into the table
                tableClient.upsertEntity(faq);
            }
            catch (Exception e)
            {
                // Output the stack trace.
                e.printStackTrace();
            }
        }

    }
}
