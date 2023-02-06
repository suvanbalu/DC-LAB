#ring algorithm

class process:
    def __init__(self, id, priority,active=True):
        self.id = id
        self.priority = priority
        self.active = active

def ring():
    n = int(input("Enter number of processes: "))
    processes = []
    for i in range(n):
        id = int(input("Enter process id: "))
        priority = int(input("Enter process priority: "))
        active = int(input("Enter process status (0 or 1): "))
        processes.append(process(id, priority,active))

    # processes.sort(key=lambda x : x.priority, reverse=True)
    while True:
        ring_arr=[]
        start = int(input("Enter starting process: "))
        for i in range(len(processes)):
            if processes[i].id == start:
                index=i
                break
        next = (index+1)%n
        while processes[index].id!=start or len(ring_arr)==0:
            if processes[index].active and processes[next].active:  
                print("--> Message is sent from process "+str(processes[index].id)+" to process "+str(processes[next].id))
                ring_arr.append(processes[index])
                # print(ring_arr[-1].id)
                index=next
                next = (next+1)%n
            elif processes[index].active and not processes[next].active:
                print("--> Message is sent from process "+str(processes[index].id)+" to process "+str(processes[next].id))
                print("<-- No Reply from process "+str(processes[next].id))
                next = (next+1)%n

        print("Election Ends")
        ring_arr.sort(key=lambda x : x.priority, reverse=True)
        print("Coordinator is process "+str(ring_arr[0].id))

        print("Do you want to continue? (y/n) : ")
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
ring()
