#bullly algorithm 

class process:
    def __init__(self, id, priority,active=True):
        self.id = id
        self.priority = priority
        self.active = active

def bully():
    n = int(input("Enter number of processes: "))
    processes = []
    for i in range(n):
        id = int(input("Enter process id: "))
        priority = int(input("Enter process priority: "))
        active = int(input("Enter process status (0 or 1): "))
        processes.append(process(id, priority,active))

    processes.sort(key=lambda x : x.priority, reverse=True)

    while True:
        start = int(input("Enter starting process: "))
        print("Election Begins")

        if start not in [x.id for x in processes]:
            print("Invalid starting process")
            break

        else:
            arr=[start]
            while len(arr)!=0:
                flag=0
                start = arr.pop(-1)
                for i in range(len(processes)):
                    if processes[i].id == start:
                        index=i
                for i in range(index-1, -1, -1):
                    if processes[i].active:
                        print("--> Message is sent from process "+str(start)+" to process "+str(processes[i].id))
                        arr.append(processes[i].id)
                        print("<-- Reply from process "+str(processes[i].id))
                        flag = 1
                    else:
                        print("--> Message is sent from process "+str(start)+" to process "+str(processes[i].id))
                        print("<-- No Reply from process "+str(processes[i].id))
                if flag==0:
                    coordinator = start
                    break

                arr.sort(reverse=True)
            
            print("Election Ends")
            print("Coordinator is process "+str(coordinator))

            print("Do you want to continue? (y/n)")
            status = input()
            if status=='n':
                break
            else:
                print("Enter the process to crash: ")
                crash = int(input())
                for i in range(len(processes)):
                    if processes[i].id == crash:
                        processes[i].active = False
                        break

bully()