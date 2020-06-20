class Solution(object):
    def twoCitySchedCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        n = len(costs) // 2
        
        # Counter variables for max ppl per city
        a_pop = 0
        b_pop = 0
        
        # Array of ppl sorted by their potential cost saved --> abs(ticket_B - ticket_A)
        sort = []
        
        min_cost = 0
        
        # add (oppt cost, index) tuples
        for i in range(len(costs)): 
            sort.append((abs(costs[i][1]-costs[i][0]), i))
        
        # sort tuples before adding to respectives cities
        # sort in reverse here bc LARGER abs diff = more cost saved per person
        sort.sort(reverse = True) 
        
        for tup in sort:
            index = tup[1]
            if costs[index][0] < costs[index][1]:
                if a_pop < n: # add so long as a city isn't already 'full'
                    a_pop += 1
                    min_cost += costs[index][0]
                else:
                    b_pop += 1
                    min_cost += costs[index][1]
            else:
                if b_pop < n:
                    b_pop += 1
                    min_cost += costs[index][1]
                else:
                    a_pop += 1
                    min_cost += costs[index][0]
            
        return min_cost
            
            
        
