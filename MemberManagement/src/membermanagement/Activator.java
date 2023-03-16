package membermanagement;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;



import java.util.List;
import java.util.Scanner;

import memberpublisher.Member;
import memberpublisher.MemberService;


public class Activator implements BundleActivator {

	ServiceReference memberServiceReference;
	private Scanner scan;

	
	public void start(BundleContext context) throws Exception {
		
		memberServiceReference = context.getServiceReference(MemberService.class.getName());
		scan = new Scanner(System.in);
		
		@SuppressWarnings("unchecked")
		MemberService memberPublisher = (MemberService) context.getService(memberServiceReference);
		
		while(true) {
			int choice;
			System.out.println("\n--------------Choose an option from Member Management--------------");
			System.out.println("1. Insert a New Member");
			System.out.println("2. Get All Memeber Details");
			System.out.println("3. Search Member Details");
			System.out.println("4. Update Member Details");
			System.out.println("5. Delete Member");
			System.out.println("6. quit");
			choice = scan.nextInt();

			
			switch(choice) {
			   
			   case 1:
				   memberPublisher.insertMemberDetails();
				   break;
			   case 2:
				   List<Member> memberList = memberPublisher.getMemberAll();
               	for (Member member : memberList) {
               	System.out.println(member.getFirstName());
               	}
//				   memberPublisher.getAllMemberDetails();
				   break;
			   case 3:
				   while(true) {
				   System.out.println("\n\nEnter NIC: ");
				   String nic = scan.nextLine();
				   
				   if(nic.isBlank()) {
					   continue;
				   }
				   else {
					   memberPublisher.searchMemberDetails(nic);
					   break;
				   }
				   }
				   break;
			   case 4:
				   System.out.println("\nEnter the name of the Member you want to update");
				   String nic = scan.nextLine();
				   memberPublisher.editMemberDetails(nic);
				   
				   break;
				   
			   case 5:
				   memberPublisher.deleteMember();
				   break;
				
			   case 6:
				   System.out.println("Exiting...");
				   System.exit(0);
				   break;
				   
			   default:
				   continue;
				   
			}
		}
			
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Member Management service stopped !");
		context.ungetService(memberServiceReference);
	}

}
