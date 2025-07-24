class Solution {
public:
    bool primeSubOperation(vector<int>& nums) {
        
        vector<int> primes;
        for(int i = 2;i <= 1000; i++)
        {
            if(prime(i))
            {
                primes.push_back(i);
            }
        }
        for(int i = nums.size() - 2; i >= 0; i--)
        {
            if(nums[i] < nums[i+1])
            {
                continue;
            }
            int diff = nums[i] - nums[i+1];
            for(int j = 0; j < primes.size(); j++)
            {
                if(primes[j] > diff && primes[j] < nums[i])
                {
                    nums[i] = nums[i] - primes[j];
                    break;
                }
            }
            if(nums[i] >= nums[i+1])
            {
                return false;
            }
        }
        return true;
    }
    bool prime(int num)
    {
        if(num == 2 || num == 3)
        {
            return true;
        }
        if(num %2 == 0 || num % 3 == 0)
        {
            return false;
        }
        for(int i = 5; i <= (int)sqrt(num); i+= 6)
        {
            if(num % i == 0 || num % (i+2) == 0)
            {
                return false;
            }
        }
        return true;
    }
};